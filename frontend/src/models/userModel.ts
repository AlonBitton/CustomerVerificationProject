class UserModel {
  public id: number;
  public email: string;
  public password: string;
  public firstName: string;
  public lastName: string;

  public constructor(
    email: string,
    password: string,
    firstName: string,
    lastName: string
  ) {
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}

export default UserModel;
