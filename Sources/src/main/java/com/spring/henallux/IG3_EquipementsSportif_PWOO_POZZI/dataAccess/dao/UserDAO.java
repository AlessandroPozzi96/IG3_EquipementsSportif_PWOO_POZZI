package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.UserRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDAO
{
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private ProviderConverter providerConverter;
    private SessionFactory sessionFactory;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter, SessionFactory sessionFactory) {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
        this.sessionFactory = sessionFactory;
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword())); //Pas de mdp en clair dans la base de données!
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(userEntity);
        //userRepository.save(userEntity);
        session.getTransaction().commit();
    }

    public ArrayList<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        ArrayList<User> users = new ArrayList<>();
        for (UserEntity entity : userEntities) {
            User user = providerConverter.userEntityToUserModel(entity);
            users.add(user);
        }
        return users;
    }

    public UserEntity findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public UserEntity findByMail(String mail) {
        return userRepository.findByMail(mail);
    }
}
