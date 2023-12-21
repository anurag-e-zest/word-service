package com.anurag.wordservice.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.anurag.wordservice.demo.dto.AuthResponse;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import sun.security.util.AuthResources;

@Service
public class AuthService {

	public AuthResponse getTableauToken() throws KeyLengthException {

   	 String secret = "mZCd7UCe3PzJFmIeTjm6ThfYth+ixh2+Zm+/xct0ZJ0=";
        String kid = "e110b784-0e36-4ca9-91de-87b31bd06c26";
        String clientId = "9440737b-f1de-42fe-9b24-0d25452b06bc";
        List<String> scopes = new ArrayList<>(Arrays.asList("tableau:views:embed"));
        String username = "leonord@who.int";

        // Create the MAC signer
        JWSSigner signer = new MACSigner(secret);

        // Build the JWT header
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.HS256)
                .keyID(kid)
                .customParam("iss", clientId)
                .build();

        // Build the JWT claims
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issuer(clientId)
                .expirationTime(new Date(new Date().getTime() + 60 * 5000)) // Expires in 1 minute
                .jwtID(UUID.randomUUID().toString())
                .audience("tableau")
                .subject(username)
                .claim("scp", scopes)
                .claim("https://tableau.com/oda","true")
                //.claim("https://tableau.com/groups", "Contractors", "Team C")
                .claim("Region", "west")
                .build();

        // Create the signed JWT
        SignedJWT signedJWT = new SignedJWT(header, claimsSet);

        try {
            // Sign the JWT
            signedJWT.sign(signer);

            // Print or use the serialized JWT
            String serializedJWT = signedJWT.serialize();
            System.out.println(serializedJWT);
            AuthResponse response = new AuthResponse();
            response.token = serializedJWT;
            return response;

            // Now you can use the serializedJWT as needed, for example, include it in your HTTP request headers.
        } catch (JOSEException e) {
            e.printStackTrace();
            return null;
        }
        
   
	}
	
	
}
