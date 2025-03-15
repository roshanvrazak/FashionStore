package com.fashionstore.exception;

public class CustomeExceptions {

	public class NotFoundException extends RuntimeException {
		public NotFoundException(String message) {
			super(message);
		}
	}

	public class BadRequestException extends RuntimeException {
		public BadRequestException(String message) {
			super(message);
		}
	}

	public class InternalServerErrorException extends RuntimeException {
		public InternalServerErrorException(String message) {
			super(message);
		}
	}

}
