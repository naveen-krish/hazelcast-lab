package lab.hazelcast.embedded;

import com.hazelcast.config.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import lab.hazelcast.embedded.service.ItemService;

@SpringBootApplication
@EnableCaching
public class SpbootHazelcastApplication { // implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpbootHazelcastApplication.class);

	// @Autowired
	// private ItemService itemService;

	public static void main(String[] args) {
		SpringApplication.run(SpbootHazelcastApplication.class, args);
	}

	@Bean
	Config config() {

		Config config = new Config();

		config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(false);
		config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
		config.getNetworkConfig().getJoin().getKubernetesConfig().setEnabled(true).setProperty("namespace", "default")
				.setProperty("service-name", "hazelcast-spboot-service");
		return config;
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * logger.info("Loading test data."); itemService.createItem(new
	 * Item("Shirt Small", BigDecimal.valueOf(28.99))); itemService.createItem(new
	 * Item("Pants Large", BigDecimal.valueOf(21.99))); }
	 */

}
