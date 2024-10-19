import './App.css';
import InfoArea from './components/InfoArea/InfoArea';
import Input from './components/Input/Input';
import InputArea from './components/InputArea/InputArea';

function App() {
  return (
    <div>
      <h1>Estacionamento de carros</h1>
      <h2>CRUD baseado em estacionamento de carros</h2>
      <InputArea title={"Hey Brother"} />
      <InfoArea />
    </div>
  );
}

export default App;
