import React, { useState } from "react";
import FormInput from "../components/formInput/FormInput";
import Logo from "../assets/images/Image 2.png";
import "./Home.css";
import ButtonComponent from "../components/buttonComponent/ButtonComponent";
import ClearAllIcon from "@mui/icons-material/ClearAll";
import Image1 from "../assets/images/Page-1.svg";
import Image2 from "../assets/images/Page-2.svg";
import Image3 from "../assets/images/Page-3.svg";
import Image4 from "../assets/images/Page-4.svg";
import Image5 from "../assets/images/Page-5.svg";
import Image6 from "../assets/images/Page-6.svg";
import Image7 from "../assets/images/Page-7.svg";

const Home: React.FC = () => {
  const [name, setName] = useState("Jeal");
  const [intention, setIntention] = useState("");
  const [role, setRole] = useState("");

  const buttons = [
    {
      img: Image1,
      text: "Le reve libere l expression",
    },
    {
      img: Image2,
      text: "Le eclaire le parcours",
    },
    {
      img: Image3,
      text: "La difference rend unique",
    },
    {
      img: Image4,
      text: "La valeur humaine met en mouvement",
    },
    {
      img: Image5,
      text: "La clé exprime le style",
    },
    {
      img: Image6,
      text: "Le parcours associe reve et realité",
    },
    {
      img: Image7,
      text: "Le ciel bleu revele l alignement",
    },
  ];

  return (
    <div className="mainContainer">
      <div className="leftSection">
        <div className="roundedP">
          <img src={Logo} className="logoContainer" />
          <div className="header">
            <h1 className="headerLabel">Pour commencer...</h1>
            <p className="headerText">
              Faire votre Shynlei, jouer avec, c'est l'occasion d'écouter vos
              rêves, de les partager et de prendre confiance dans votre
              richesse.
            </p>
          </div>
        </div>
        <div className="formContainer">
          <FormInput
            label="Nom et prénom :"
            placeholder={name}
            callback={setName}
            underlined={true}
          />
          <FormInput
            label="Mon intention :"
            placeholder="L'intention, l'objectif de ce Shynlei"
            callback={setIntention}
            underlined={false}
          />
          <FormInput
            label="Mon rôle :"
            placeholder=""
            callback={setRole}
            underlined={true}
          />
        </div>
      </div>
      <div className="rightSection">
        <div className="dropDownIcon">
          <ClearAllIcon />
        </div>
        <h1 className="headerLabel">Votre Shynlei c'est..</h1>
        <label className="headerTextRight">
          7 étapes, 2 fiches pour prendre note des rencontres, 1 page pour
          éclairer le sens, 3 interprétations pour vous aider..
        </label>
        <div className="buttonsContainer">
          {buttons.map((button, index) => (
            <ButtonComponent key={index} src={button.img} text={button.text} />
          ))}
        </div>
        <button className="reveButton">EXPRIMER MES REVES &gt;</button>
      </div>
    </div>
  );
};

export default Home;
