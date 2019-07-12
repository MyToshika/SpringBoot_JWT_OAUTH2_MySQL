package com.mytoshika.auth.exception;

import java.util.Arrays;

public enum ExceptionCodes {

	AUTH001("Login Failed"), AUTH002("User Not Found"),AUTH003("Unknown Exception");

	String exceptionMessage;

	ExceptionCodes(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public static ExceptionCodes getExceptionCode(String exceptionMessage) {
		return Arrays.asList(ExceptionCodes.values()).stream().filter(e -> {
			return e.getExceptionMessage().equals(exceptionMessage);
		}).findFirst().get();
	}
}
