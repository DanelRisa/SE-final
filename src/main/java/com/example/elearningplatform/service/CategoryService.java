package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.category.CategoryRequestDTO;
import com.example.elearningplatform.dto.category.CategoryResponseDTO;
import com.example.elearningplatform.mapper.CategoryMapper;
import com.example.elearningplatform.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    @Transactional
    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }

    public List<CategoryResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO getById(Long id) {
        return repository.findById(Math.toIntExact(id))
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(Math.toIntExact(id))) {
            throw new RuntimeException("Category not found with id: " + id);
        }
        repository.deleteById(Math.toIntExact(id));
    }
}