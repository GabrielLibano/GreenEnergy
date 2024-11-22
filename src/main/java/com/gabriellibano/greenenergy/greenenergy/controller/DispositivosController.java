package com.gabriellibano.greenenergy.greenenergy.controller;
import java.util.List;

import com.gabriellibano.greenenergy.greenenergy.dtos.DispositivosRequestCreateDto;
import com.gabriellibano.greenenergy.greenenergy.dtos.DispositivosRequestUpdateDto;
import com.gabriellibano.greenenergy.greenenergy.dtos.DispositivosResponseDto;
import com.gabriellibano.greenenergy.greenenergy.mapper.DispositivosMapper;
import com.gabriellibano.greenenergy.greenenergy.repository.DispositivosRepository;
import com.gabriellibano.greenenergy.greenenergy.service.DispositivosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dispositivos")
@RequiredArgsConstructor
public class DispositivosController {

    private final DispositivosService dispositivosService;
    private final DispositivosMapper dispositivosMapper;
    private final DispositivosRepository dispotivosRepository;

    @GetMapping
    public ResponseEntity<List<DispositivosResponseDto>> list() {
        List<DispositivosResponseDto> dtos = dispositivosService.list()
                .stream()
                .map(e -> dispositivosMapper.toDto(e))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<DispositivosResponseDto> create(@RequestBody DispositivosRequestCreateDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        dispositivosMapper.toDto(
                                dispositivosService.save(dispositivosMapper.toModel(dto)))
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<DispositivosResponseDto> update(
            @PathVariable Long id,
            @RequestBody DispositivosRequestUpdateDto dto) {
        if (! dispositivosService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
                .body(
                        dispositivosMapper.toDto(
                                dispositivosService.save(dispositivosMapper.toModel(id, dto)))
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! dispositivosService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        dispositivosService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<DispositivosResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        dispositivosService
                                .findById(id)
                                .map(e -> dispositivosMapper.toDto(e))
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );
    }

    @GetMapping("/find")
    public  ResponseEntity<?> findByNome(
            @RequestParam String nome) {

        return ResponseEntity.ok().body(dispotivosRepository.findByNome(nome));
    }
}
