package test.resource;

import org.junit.Test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

/**
 * @author WangPingChun
 */
public class ResourceTests {
	@Test
	public void resourceLoader() {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		final Resource fileResource1 = new FileSystemResourceLoader().getResource("D:/serial.txt");
		System.out.println("fileResource1 is FileSystemResource " + (fileResource1 instanceof FileSystemResource));

		final Resource fileResource2 = resourceLoader.getResource("/serial.txt");
		System.out.println("fileResource2 is ClassPathResource " + (fileResource2 instanceof ClassPathResource));

		final Resource urlResource1 = resourceLoader.getResource("file:/serial.txt");
		System.out.println("urlResource1 is UrlResource " + (urlResource1 instanceof UrlResource));

		final Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
		System.out.println("urlResource2 is UrlResource " + (urlResource2 instanceof UrlResource));
	}
}
