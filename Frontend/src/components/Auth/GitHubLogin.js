import React from 'react';
import './GitHubLogin.css'

const clientId = 'c1b613314ee5f221f1aa';
const redirectURL = 'http://localhost:3000'; 

const GitHubLogin = () => {
  const handleLogin = () => {
    window.location.href = `https://github.com/login/oauth/authorize?client_id=${clientId}&redirect_uri=${encodeURIComponent(redirectURL)}`;
  };

  return (
    <div>
      <button onClick={handleLogin} class="login_button">Login with GitHub</button>
    </div>
  );
};

export default GitHubLogin;