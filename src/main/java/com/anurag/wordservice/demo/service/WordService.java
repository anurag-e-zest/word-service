package com.anurag.wordservice.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

@Service
public class WordService {
    public List<String> getTopNLargestWords(int count, String sorting, String text) {
        // Split the text into individual words
        String[] words = text.split("\\s+");

        // Create a custom comparator based on the sorting order
        Comparator<String> comparator;
        if (sorting.equals("length")) {
            comparator = Comparator.comparingInt(String::length).reversed();
        } else {
            comparator = Comparator.naturalOrder();
        }

        // Create a priority queue to store the top N largest words
        PriorityQueue<String> queue = new PriorityQueue<>(count, comparator);

        // Iterate over the words and add them to the priority queue
        for (String word : words) {
            if (queue.size() < count) {
                queue.offer(word);
            } else {
                String smallestWord = queue.peek();
                if (comparator.compare(word, smallestWord) > 0) {
                    queue.poll();
                    queue.offer(word);
                }
            }
        }

        // Convert the priority queue to a list and sort it based on the sorting order
        List<String> result = new ArrayList<>(queue);
        result.sort(comparator);

        return result;
    }
}
