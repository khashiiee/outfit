package com.hm.outfit.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.hm.outfit.model.ClothingStyle;
import com.hm.outfit.model.Size;
import com.hm.outfit.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends CosmosRepository<User, String> {
    User findByEmail(String email);
    List<User> findByPreferredStylesContaining(ClothingStyle style);
    List<User> findByPreferredSizeIn(Collection<Size> preferredSize);
}

