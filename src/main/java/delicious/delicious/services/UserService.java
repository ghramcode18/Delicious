package delicious.delicious.services;

    

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import delicious.delicious.entities.UserEntity;
import delicious.delicious.exceptions.UserException;
import delicious.delicious.models.UserModel;
import delicious.delicious.repositories.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;
    
  
  
    public UserModel registerUser(UserModel user) throws UserException 
    {
        if(user.getEmail() != null && user.getPassword() != null && user.getUserName() != null)
        {
            if(userRepo.findByEmail(user.getEmail()).isEmpty())
            {
                UserEntity entity = userRepo.save(UserModelToUserEntity(user));
                return user.id(entity.getId());
            }else{
                throw new UserException("this email is already exist");
            }
        }else{
            throw new UserException("required fields are null");
        }
    }

  
    
    public UserModel signIn(UserModel user) throws UserException
    {
        Optional<UserEntity> entity;
        if((entity = userRepo.findByEmail(user.getEmail())).isEmpty())
        {
            throw new UserException("no user with this email");
        }else{
            if(entity.get().getPassword().equals(user.getPassword()))
            {
                return UserEntityToUserModel(entity.get());
            }else{
                throw new UserException("wrong password");
            }

        }
    }
    
    public  UserModel  UserEntityToUserModel(UserEntity user)
    {
        UserModel model = new UserModel()
        .email(user.getEmail())
        .userName(user.getName())
        .id(user.getId())
        .password(user.getPassword());

        return model;


    }

    public  UserEntity  UserModelToUserEntity(UserModel user)
    {
        UserEntity entity = new UserEntity()
        .email(user.getEmail())
        .name(user.getUserName())
        .id(user.getId())
        .password(user.getPassword());

        return entity;


    }


    public  UserEntity logout (UserModel userModel)
    {
        UserEntity entity;
        if(userModel.getId()!= null)
        entity = userRepo.findById(userModel.getId()).orElseThrow(()-> new UserException("no user with this id"));
        entity = new UserEntity();
        userRepo.save(entity);
        return entity;


        
    }

    // public UserModel updateUser(UserModel user){
    //     if(user.getId() == null)
    //         throw new UserException("can't update user without id");
    //     UserEntity entity = userRepo.findById(user.getId()).orElseThrow(()-> new UserException("no user with this id"));
    //     entity.userName(user.getUserName()).password(user.getPassword()).email(user.getEmail());
    //     userRepo.save(entity);
    //     return userMapper.UserEntityToUserModel(entity); 
    // }


  

}
