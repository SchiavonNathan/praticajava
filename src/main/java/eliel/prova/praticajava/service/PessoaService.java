package eliel.prova.praticajava.service;

import eliel.prova.praticajava.dto.PessoaDTO;
import eliel.prova.praticajava.dto.PessoaRequestDTO;
import eliel.prova.praticajava.model.Pessoa;
import eliel.prova.praticajava.model.Trabalho;
import eliel.prova.praticajava.repository.PessoaRepository;
import eliel.prova.praticajava.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<PessoaDTO> listarTodas() {
        return pessoaRepository.findAll().stream()
                .map(p -> new PessoaDTO(p.getId(), p.getNome(), p.getCpf(),
                        p.getTrabalho() != null ? p.getTrabalho().getNome() : null))
                .collect(Collectors.toList());
    }

    public PessoaDTO criar(PessoaRequestDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());

        if (dto.getTrabalhoId() != null) {
            Trabalho trabalho = trabalhoRepository.findById(dto.getTrabalhoId())
                    .orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));
            pessoa.setTrabalho(trabalho);
        }

        Pessoa salva = pessoaRepository.save(pessoa);
        return new PessoaDTO(salva.getId(), salva.getNome(), salva.getCpf(),
                salva.getTrabalho() != null ? salva.getTrabalho().getNome() : null);
    }

    public PessoaDTO atualizar(int id, PessoaRequestDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());

        if (dto.getTrabalhoId() != null) {
            Trabalho trabalho = trabalhoRepository.findById(dto.getTrabalhoId())
                    .orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));
            pessoa.setTrabalho(trabalho);
        } else {
            pessoa.setTrabalho(null);
        }

        Pessoa atualizada = pessoaRepository.save(pessoa);
        return new PessoaDTO(atualizada.getId(), atualizada.getNome(), atualizada.getCpf(),
                atualizada.getTrabalho() != null ? atualizada.getTrabalho().getNome() : null);
    }

    public void deletar(int id) {
        pessoaRepository.deleteById(id);
    }

}
