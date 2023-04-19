import axios from "axios";
import CredentialsModel from "models/CredentialsModel";
import UserModel from "models/userModel";
import { toast } from "react-toastify";
import { AuthActionType, authStore } from "redux/authState";
import appConfig from "utils/appConfig";

class AuthService {
  public async login(credentials: CredentialsModel): Promise<any> {
    try {
      const response = await axios.post(appConfig.loginUrl, {
        email: credentials.email,
        password: credentials.password,
      });
      const token = response.data;

      authStore.dispatch({ type: AuthActionType.Login, payload: token });
      toast.success(
        "You have been authenticated, being redirected to Home page",
        {
          position: "top-center",
          autoClose: 1500,
        }
      );
      return response;
    } catch (error) {
      toast.error(error.response.data.message, {
        position: "top-center",
        autoClose: 2000,
      });
      return error;
    }
  }

  public async register(newUser: UserModel): Promise<any> {
    try {
      const response = await axios.post(appConfig.signUpURL, {
        email: newUser.email,
        firstName: newUser.firstName,
        lastName: newUser.lastName,
        password: newUser.password,
      });
      toast.success(response.data, { position: "top-center", autoClose: 4000 });
      return response;
    } catch (error) {
      toast.error(error.response.data, {
        position: "top-center",
        autoClose: 2000,
      });
      return error;
    }
  }

  public logout(): void {
    authStore.dispatch({ type: AuthActionType.Logout });
  }
}
const authService = new AuthService();

export default authService;
