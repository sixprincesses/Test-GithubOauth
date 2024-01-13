import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import GitHubLogin from './components/Auth/GitHubLogin';
import GitHubCallback from './components/Auth/GitHubCallback';

const App = () => {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <GitHubLogin />
        </header>

        <Routes>
          <Route path="/callback" element={<GitHubCallback />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
