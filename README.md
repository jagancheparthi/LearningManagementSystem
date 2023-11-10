# LearningManagementSystem
#Project will contain majorly three Modules.
  Employee
  Mentor
  Admin
#Security is integrated to APIs by using Spring Security.
APIs are secured you can access only with proper access.
Registration and Login are open APIs (not secured), you will find in seperate class called AppUser Controller.
Followed Three layered Architecture ,you will find 
  controller classes only contain Handler methods.
  Service layer will contain all the Bussiness logic.
  Repository layer contains database related logic.(Here I have implemented Spring Data Jpa, so there is not much database logics are there.)
Admin only can access admin controller handler methods, through proper Authentication and Autherization.
Validations are thoroughly implemented by using Spring validation.
Valid data has to give as input, If not you will get error.
you will get quick response due to enabling of Cache mechanism by using Spring cache.
I have implemented cache mechanism in Admin controller methods.
