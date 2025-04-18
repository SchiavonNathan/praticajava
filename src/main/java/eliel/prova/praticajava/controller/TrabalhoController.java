package eliel.prova.praticajava.controller;

import eliel.prova.praticajava.dto.TrabalhoDTO;
import eliel.prova.praticajava.dto.TrabalhoRequestDTO;
import eliel.prova.praticajava.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    public List<TrabalhoDTO> listarTodos() {
        return trabalhoService.listarTodos();
    }

    @PostMapping
    public TrabalhoDTO criar(@RequestBody TrabalhoRequestDTO dto) {
        return trabalhoService.criar(dto);
    }

    @PutMapping("/{id}")
    public TrabalhoDTO atualizar(@PathVariable int id, @RequestBody TrabalhoRequestDTO dto) {
        return trabalhoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        trabalhoService.deletar(id);
    }
}
