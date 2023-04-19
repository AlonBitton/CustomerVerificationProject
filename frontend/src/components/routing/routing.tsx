import { Route, Routes } from "react-router-dom";
import AuthLayout from "components/loginArea/auth-main-layout.component";
import VerifyCard from "components/loginArea/verify-layout-comonent";
import { HomePage } from "components/homeArea/home-layout.component";
import { useState, useEffect } from "react";
import { authStore } from "redux/authState";
import ErrorPage from "components/404/errorPage-layout.component";

function Routing(): JSX.Element {
  const [isLoggedIn, setIsLoggedIn] = useState(null);

  useEffect(() => {
    const unsubscribe = authStore.subscribe(() => {
      const state = authStore.getState();
      const loggedIn = !!state.user;
      setIsLoggedIn(loggedIn);
    });

    const state = authStore.getState();
    const loggedIn = !!state.user;
    setIsLoggedIn(loggedIn);

    return unsubscribe;
  }, []);

  return (
    <>
      <Routes>
        <Route path="/error" element={<ErrorPage />} />
        {isLoggedIn ? (
          <>
            <Route path="/*" element={<HomePage />} />
            <Route path="/verify" element={<VerifyCard />} />
          </>
        ) : (
          <>
            <Route path="/error" element={<ErrorPage />} />
            <Route path="/verify" element={<VerifyCard />} />
            <Route path="/*" element={<AuthLayout />} />
          </>
        )}
      </Routes>
    </>
  );
}

export default Routing;
