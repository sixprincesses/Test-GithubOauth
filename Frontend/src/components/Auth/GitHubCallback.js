import React, { useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import axios from 'axios'

const GitHubCallback = () => {
  const location = useLocation();
  
  const getAccessToken = async (authorizationCode) => { 
    let callbackURL = 'http://localhost:8080/users/github/callback'; // 서버에 access token 요청 URL
    await axios.post(callbackURL, {
      authorizationCode
    }) 
  //body에 authorizationCode를 실어서 POST요청을 보낸다.
    .then(res => { 
      this.setState({
        isLogin: true,
        accessToken: res.data.accessToken
      });
    })
    .catch(err => {
      //console.log(err);
    })
  }

  useEffect(() => {
    const params = new URLSearchParams(location.search);
    const code = params.get('code');
    getAccessToken(code)
    
    window.location.href = '/';
  }, [location.search]);

  return (
    <div>
      <p>Processing GitHub callback...</p>
    </div>
  );
};

export default GitHubCallback;
