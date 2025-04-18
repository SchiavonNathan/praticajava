package eliel.prova.praticajava.service;

import eliel.prova.praticajava.dto.TrabalhoDTO;
import eliel.prova.praticajava.dto.TrabalhoRequestDTO;
import eliel.prova.praticajava.model.Trabalho;
import eliel.prova.praticajava.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<TrabalhoDTO> listarTodos() {
        return trabalhoRepository.findAll().stream()
                .map(t -> new TrabalhoDTO(t.getId(), t.getNome(), t.getEndereco()))
                .collect(Collectors.toList());
    }

    public TrabalhoDTO criar(TrabalhoRequestDTO dto) {
        Trabalho trabalho = new Trabalho(dto.getNome(), dto.getEndereco());
        Trabalho salvo = trabalhoRepository.save(trabalho);
        return new TrabalhoDTO(salvo.getId(), salvo.getNome(), salvo.getEndereco());
    }

    public TrabalhoDTO atualizar(int id, TrabalhoRequestDTO dto) {
        Trabalho trabalho = trabalhoRepository.findById(id).get();
        trabalho.setNome(dto.getNome());
        trabalho.setEndereco(dto.getEndereco());

        Trabalho atualizado = trabalhoRepository.save(trabalho);

        return new TrabalhoDTO(atualizado.getId(), atualizado.getNome(), atualizado.getEndereco());
    }

    public void deletar(int id) {
        trabalhoRepository.deleteById(id);
    }
}
