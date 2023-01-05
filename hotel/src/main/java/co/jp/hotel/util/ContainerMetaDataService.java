package co.jp.hotel.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ContainerMetaDataService {

	private static final String ENVIRONMENT_VARIABLE_ECS_CONTAINER_METADATA_URI = "ECS_CONTAINER_METADATA_URI";

	private static final String DEFAULT_VALUE = "EMPTY";

	// @Value(${ENVIRONMENT_VARIABLE_NAME:DEFAULT_VALUE})
	@Value("${" + ENVIRONMENT_VARIABLE_ECS_CONTAINER_METADATA_URI + ":" + DEFAULT_VALUE + "}")
	private String containerMetadataUri;

	public String retrieveContainerMetadataInfo() {

		if (containerMetadataUri.contains(DEFAULT_VALUE)) {
			log.info("Environment Variable Not Available - " + ENVIRONMENT_VARIABLE_ECS_CONTAINER_METADATA_URI);
			return "NA";
		}

		return new RestTemplate().getForObject(containerMetadataUri, String.class);
	}

}
