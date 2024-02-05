package br.com.app.transferenciabancaria.client;

import br.com.app.transferenciabancaria.client.dto.response.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiValidateClient", url = "https://run.mocky.io/v3/4abec2b1-4f6d-4c08-b3cd-eda87bed56e5")
public interface ApiValidateClient {

    @GetMapping
    ApiValidateResponse validate();
}
