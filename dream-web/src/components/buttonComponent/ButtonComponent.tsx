import React from "react";
import "./ButtonComponent.css";

interface ButtonComponentProps {
  src: string;
  text: string;
}

const ButtonComponent: React.FC<ButtonComponentProps> = ({ src, text }) => {
  return (
    <div className="buttonContainer">
      <img src={src} className="buttonImg" />
      <text className="buttonText">{text}</text>
    </div>
  );
};

export default ButtonComponent;
