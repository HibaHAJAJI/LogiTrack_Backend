package com.example.demo.service.ServiceImpl;


import com.example.demo.dto.client.ClientRequestDTO;
import com.example.demo.dto.client.ClientResponseDTO;
import com.example.demo.entity.Client;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.repositorie.ClientRepos;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl  implements ClientService {

    private final ClientRepos repos;
    private final ClientMapper mapper;

    public ClientResponseDTO addClient(ClientRequestDTO dto){
        Client client= mapper.toEntity(dto);
        return mapper.toDto(repos.save(client));
    }

    public Page<ClientResponseDTO> findAllClients(Pageable pageable){
        return repos.findAll(pageable).map(mapper::toDto);
    }

    public ClientResponseDTO findById(Long id) {
        Client client = repos.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable !"));
        return mapper.toDto(client);
    }

    public void deleteById(Long id) {
        if (!repos.existsById(id)) {
            throw new RuntimeException("Client introuvable !");
        }
        repos.deleteById(id);
    }
}
