package eliel.prova.praticajava.controller;

import eliel.prova.praticajava.dto.PessoaDTO;
import eliel.prova.praticajava.dto.PessoaRequestDTO;
import eliel.prova.praticajava.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import eliel.prova.praticajava.model.Pessoa;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDTO> listarTodas() {
        return pessoaService.listarTodas();
    }

    @PostMapping
    public PessoaDTO criar(@RequestBody PessoaRequestDTO dto) {
        return pessoaService.criar(dto);
    }

    @PutMapping("/{id}")
    public PessoaDTO atualizar(@PathVariable int id, @RequestBody PessoaRequestDTO dto) {
        return pessoaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        pessoaService.deletar(id);
    }

}
