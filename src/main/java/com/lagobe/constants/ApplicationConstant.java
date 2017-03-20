package com.lagobe.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class ApplicationConstant {

	public final static String TemporaryFolder = "temporary";

	public static String Bucket;

	@Value("${cloud.aws.s3.bucket}")
	private void setBucket(String bucket) {
		Bucket = bucket;
	}


	private ApplicationConstant() {

	}

}
