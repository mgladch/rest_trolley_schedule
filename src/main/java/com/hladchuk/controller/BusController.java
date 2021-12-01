package com.hladchuk.controller;

import com.hladchuk.model.transport.Bus;
import com.hladchuk.mapper.BusMapper;
import com.hladchuk.model.dto.BusDto;
import com.hladchuk.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class BusController {
    BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/buses")
    public ResponseEntity<List<BusDto>> findAll() {
        return ResponseEntity.ok(BusMapper.INSTANCE.busToBusDtos(busService.findAll()));
    }

    @PostMapping("/buses")
    public ResponseEntity<BusDto> create(@RequestBody BusDto busDto) {
        busService.save(BusMapper.INSTANCE.toBus(busDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(busDto);
    }

    @GetMapping(value = "/busById/{id}")
    public ResponseEntity<BusDto> findById(@PathVariable int id) {
        Optional<Bus> bus = busService.findById(id);

        return ResponseEntity.ok(BusMapper.INSTANCE.toDto(bus.get()));
    }

    @PutMapping("/buses/{id}")
    public ResponseEntity<BusDto> update(@PathVariable int id, @RequestBody BusDto busDto) {
        Bus bus = BusMapper.INSTANCE.toBus(busDto);
        bus.setId(id);

        busService.save(bus);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(busDto);
    }

    @DeleteMapping("/buses/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        busService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
