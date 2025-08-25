package com.wipro.mohan.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "THEATRE-SERVICE", url = "${theatre.service.url}")
public interface TheatreFeign {
    @PostMapping("/api/theatres/idsOfTheatreNames")
    List<Long> getTheatresByName(@RequestBody List<String> names);
}

