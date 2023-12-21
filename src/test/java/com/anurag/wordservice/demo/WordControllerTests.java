/*
 * package com.anurag.wordservice.demo;
 * 
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.setup.MockMvcBuilders;
 * 
 * import com.anurag.wordservice.demo.controller.WordController; import
 * com.anurag.wordservice.demo.service.WordService;
 * 
 * public class WordControllerTests { private MockMvc mockMvc;
 * 
 * @BeforeEach void setup() { WordService wordService = new WordService();
 * WordController wordController = new WordController(wordService); mockMvc =
 * MockMvcBuilders.standaloneSetup(wordController).build(); }
 * 
 * @Test() void testGetTopNLargestWords() throws Exception { String requestJson
 * =
 * "{\"count\": 5, \"sorting\": \"length\", \"text\": \"When I consider how my light is spent, "
 * + "Ere half my days, in this dark world and wide, " +
 * "And that one Talent which is death to hide " +
 * "Lodged with me useless, though my Soul more bent " +
 * "To serve therewith my Maker, and present " +
 * "My true account, lest he returning chide; " +
 * "\\\"Doth God exact day-labour, light denied?\\\" " +
 * "I fondly ask. But patience, to prevent " +
 * "That murmur, soon replies, \\\"God doth not need " +
 * "Either man’s work or his own gifts; who best " +
 * "Bear his mild yoke, they serve him best. His state " +
 * "Is Kingly. Thousands at his bidding speed " +
 * "And post o’er Land and Ocean without rest: " +
 * "They also serve who only stand and wait.\"}";
 * 
 * mockMvc.perform(post("/top-words") .contentType(MediaType.APPLICATION_JSON)
 * .content(requestJson)) .andExpect(status().isOk())
 * .andExpect(jsonPath("$[0]").value("day-labour,"))
 * .andExpect(jsonPath("$[1]").value("therewith"))
 * .andExpect(jsonPath("$[2]").value("returning"))
 * .andExpect(jsonPath("$[3]").value("patience,"))
 * .andExpect(jsonPath("$[4]").value("Thousands")); } }
 */