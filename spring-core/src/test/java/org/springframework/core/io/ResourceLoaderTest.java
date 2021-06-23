package org.springframework.core.io;

import org.junit.jupiter.api.Test;

/**
 * @author WangPingChun
 */
class ResourceLoaderTest {
	@Test
	void test() {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource fileResource1 = resourceLoader.getResource("D:/Users/chenming673/Documents/spark.txt");
		System.out.println("fileResource1 is FileSystemResource:" + (fileResource1 instanceof FileSystemResource));

	}

	@Test
	void test1() {
	}
}
