package com.revature.demojwtauth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@SpringBootApplication(scanBasePackages = {
		"com.revature.demojwtauth.controllers",
		"com.revature.demojwtauth.services",
		"com.revature.demojwtauth.repositories"},
		exclude = {DataSourceAutoConfiguration.class}
)
public class DemoJwtAuthApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoJwtAuthApplication.class, args);
//
//		String key = ctx.getEnvironment().getProperty("jwt-secret-key");
//		System.out.println(key);
//		Key decodedKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
//
//		String token = Jwts.builder()
//				.issuer("revature")
//				.subject("authentication")
//				.claim("username", "kplummer")
//				.claim("role", "admin")
//				.issuedAt(Date.from(Instant.now()))
//				.expiration(Date.from(Instant.now().plus(Duration.ofDays(7))))
//				.signWith(decodedKey, SignatureAlgorithm.HS256)
//				.compact();
//
//		System.out.println(token);

//		String jws = Jwts.builder()
//				.setIssuer("Stormpath")//check out ClaimsMutator docs for non-deprecated methods
//				.setSubject("msilverman")
//				.claim("name", "Micah Silverman")
//				.claim("scope", "admins")
//				// Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
//				.setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
//				// Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
//				.setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
//				.signWith(
//						SignatureAlgorithm.HS256,
//						TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
//				)
//				.compact();


	}

}
