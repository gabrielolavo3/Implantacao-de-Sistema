// import logo from './logo.svg';
import {useEffect, useState} from 'react'
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';

function App() 
{
  useEffect(()=>{
    fetch("http://localhost:8080/listar")
    .then(retorno => retorno.json())
    .then(retorno_convertido => setVeiculos(retorno_convertido))
  }, [])

  const veiculo = {
    codigo: 0,
    marca:"",
    modelo:"",
    ano: ""
  }

  const [btnCadastrar, setBtnCadastrar] = useState(true)
  const [veiculos, setVeiculos] = useState([])
  const [objVeiculo, setObjVeiculo] = useState(veiculo)
  
  const aoDigitar = (e)=>{
    setObjVeiculo({...objVeiculo, [e.target.name]: e.target.value})
  }

  const cadastrar = ()=>{
    fetch("http://localhost:8080/cadastrar",{
      method: "post",
      body: JSON.stringify(objVeiculo),
      headers:{
        "Content-type":"application/json",
        "Accept":"application/json"
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido=>{
      if (retorno_convertido.mensagem !== undefined)
      {
        alert(retorno_convertido.mensagem)
      }
      else
      {
        setVeiculos([...veiculos, retorno_convertido])
        alert("Veículo cadastrado com sucesso!")
        limparFormulario()
      }
    })
  }

  const limparFormulario = ()=>{
    setObjVeiculo(veiculo)
  }

  const selecionarVeiculo = (indice) =>{
    setObjVeiculo(veiculos[indice])
    setBtnCadastrar(true)
  }

  const remover = ()=>{
    fetch("http://localhost:8080/remover/"+objVeiculo.codigo,{
      method: "delete",    
      headers:{
        "Content-type":"application/json",
        "Accept":"application/json"
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido=>{
      alert("Veículo removido com sucesso!")
      
      let vetorTemp = [...veiculos] // cópia do vetor

      let indice = vetorTemp.findIndex((p)=>{
        return p.codigo === objVeiculo.codigo
      })

      vetorTemp.splice(indice, 1) // Remove veículo do vetor      
      setVeiculos(vetorTemp) // Atualza o vetor
      limparFormulario()
    })
  }

  const alterar = ()=>{
    fetch("http://localhost:8080/alterar",{
      method: "put",
      body: JSON.stringify(objVeiculo),
      headers:{
        "Content-type":"application/json",
        "Accept":"application/json"
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido =>{
      if (retorno_convertido.mensagem !== undefined)
      {
        alert(retorno_convertido.mensagem)
      }
      else
      {        
        alert("Veículo alterado com sucesso!")

        let vetorTemp = [...veiculos]

        let indice = vetorTemp.findIndex((p)=>{
          return p.codigo === objVeiculo.codigo
        })

        vetorTemp[indice] = objVeiculo // Altera o veículo do vetor
        
        setVeiculos(vetorTemp)
        limparFormulario()
      }
    })
  }

  return (    
    <div className="bloco">  
      <h1 className="titulo">Gestão de Veículos</h1>
        <div className="container">
          {/* <p>{JSON.stringify(objVeiculo)}</p> */}
          <Formulario botao = {btnCadastrar} eventoTeclado = {aoDigitar} cadastrar = {cadastrar} obj = {objVeiculo} cancelar = {limparFormulario} remover={remover} alterar={alterar} temDados = {veiculos.length > 0}/>
          <Tabela vetor = {veiculos} selecionar = {selecionarVeiculo}/>
        </div>  
    </div>  
  );
}

export default App;
