package com.hladchuk.controller;

import com.hladchuk.model.PublicTransport;
import com.hladchuk.mapper.postmapper.PostTransportMapper;
import com.hladchuk.model.dto.postdto.PostTransportDto;
import com.hladchuk.service.PublicTransportService;
import com.hladchuk.util.PublicTransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class PublicTransportController {
    PublicTransportService publicTransportService;
    PublicTransportUtil publicTransportUtil;

    @Autowired
    public PublicTransportController(PublicTransportService publicTransportService, PublicTransportUtil publicTransportUtil) {
        this.publicTransportService = publicTransportService;
        this.publicTransportUtil = publicTransportUtil;
    }

    @GetMapping("/transports")
    public ResponseEntity<List<PostTransportDto>> findAll() {
        return ResponseEntity.ok(PostTransportMapper.INSTANCE.transportToPostTransportDtos(publicTransportService.findAll()));
    }

    @PostMapping("/transports")
    public ResponseEntity<PostTransportDto> create(@RequestBody PostTransportDto postTransportDto) {
        publicTransportService.save(PostTransportMapper.INSTANCE.postDtoToPublicTransport(postTransportDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(postTransportDto);
    }

    @GetMapping(value = "/transportById/{id}")
    public ResponseEntity<PostTransportDto> findById(@PathVariable int id) {
        Optional<PublicTransport> publicTransport = publicTransportService.findById(id);

        return ResponseEntity.ok(PostTransportMapper.INSTANCE.toDto(publicTransport.get()));
    }

    @PutMapping("/transports/{id}")
    public ResponseEntity<PostTransportDto> update(@PathVariable int id, @RequestBody PostTransportDto postTransportDto) {
        PublicTransport publicTransport = PostTransportMapper.INSTANCE.postDtoToPublicTransport(postTransportDto);
        publicTransport.setAmountOfSeats(postTransportDto.getAmountOfSeats());

        publicTransportService.save(publicTransport);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(postTransportDto);
    }

    @DeleteMapping("/transports/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        publicTransportService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
