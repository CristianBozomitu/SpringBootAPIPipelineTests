package com.example.demo.Repository;

import com.example.demo.Dto.PostDto;
import com.example.demo.Entity.Post;
import com.example.demo.Mapper.PostMapper;
import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class PostRepository implements IRepository<PostDto> {
    private List<Post> Postlist;
    private final PostMapper mapper;

    @Override
    public PostDto getById(Long id) {
        return Postlist.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("Resource not found"));
    }

    @Override
    public List<PostDto> getAll() {
        return List.of(Postlist.stream()
                .map(mapper::toDto)
                .toArray(PostDto[]::new));
    }

    @Override
    public void deleteById(Long id) {
        boolean isRemoved = Postlist.removeIf(p -> p.getId().equals(id));
        if(!isRemoved){
            throw new NotFoundException("Resource not found");
        }
    }

    @Override
    public void update(PostDto entity) {
        Post post = Postlist.stream()
                .filter(p -> p.getId().equals(entity.id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Resource not found"));

        post.setTitle(entity.title);
        post.setContent(entity.content);
    }

    @Override
    public PostDto create(PostDto dto) {
        Post post = mapper.toEntity(dto);
        Postlist.add(post);
        return mapper.toDto(post);
    }
}
