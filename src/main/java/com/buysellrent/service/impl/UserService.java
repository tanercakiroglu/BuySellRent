package com.buysellrent.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.buysellrent.DTO.User;
import com.buysellrent.domain.response.CheckCredentialResponse;
import com.buysellrent.idao.IUserDAO;
import com.buysellrent.iservice.IUserService;
import com.buysellrent.util.Constants;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class UserService implements IUserService {

	@Qualifier("userDAO")
	@Autowired
	private IUserDAO userDAO;

	@Override
	public CheckCredentialResponse checkCredential(User credential) {
		CheckCredentialResponse response = null;

		if (userDAO.checkCredential(credential)) {
			final StringBuilder strbuild = new StringBuilder();
			strbuild.append("Bearer ");
			strbuild.append(signAndSerializeJWT(createJWT(), Constants.SECRET_KEY));
			response = new CheckCredentialResponse(Constants.APPROVED,true, strbuild.toString());
		}
		return response;
	}
	
	
	
	private JWTClaimsSet createJWT() {

		JWTClaimsSet claimsSet = new JWTClaimsSet();
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 10);
		Date tenFromNow = cal.getTime();
		claimsSet.setSubject("alice");
		claimsSet.setIssueTime(now);
		claimsSet.setIssuer("clearsettle.site.com");
		claimsSet.setExpirationTime(tenFromNow);
		claimsSet.setNotBeforeTime(now);
		return claimsSet;
	}

	private String signAndSerializeJWT(JWTClaimsSet claimsSet, String secret) {
		JWSSigner signer = new MACSigner(secret);
		SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
		try {
			signedJWT.sign(signer);
			return signedJWT.serialize();
		} catch (JOSEException e) {
			e.printStackTrace();
			return null;
		}
	}

}
