// package delicious.delicious.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// import delicious.delicious.exceptions.UserException;
// import delicious.delicious.models.UserModel;
// import delicious.delicious.services.UserService;

// @RestController
// @RequestMapping(path = {"/api/v1/auth","/api/v1/user"})
// public class UserController {
//     @Autowired
//     UserService userService;
 
//      @RequestMapping(value="/register", method=RequestMethod.POST)
//      public Object registerUser(@RequestBody UserModel user) {
//          try{
//              return userService.registerUser(user);
//          }catch(UserException e)
//          {
//              return e.getMessage();
//          }
//      }
     
//     @RequestMapping(value="/signin", method=RequestMethod.POST)
//     public Object signIn(@RequestBody UserModel user) {
//         try{
//             return userService.signIn(user);
//         }catch(UserException e)
//         {
//             return e.getMessage();
//         }                                                                                                                                                                       
//     }
    
//     @RequestMapping(value = "/logout", method = RequestMethod.POST)
//     public Object logout (@RequestBody UserModel user)
//     {try {
        
//         return userService.logout(user);

//     } catch (UserException e) {
//        return e.getMessage();

//     }}


// }
