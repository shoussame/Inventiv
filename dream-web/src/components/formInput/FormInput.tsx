import React, { ChangeEvent } from "react";
import "./FormInput.css";

interface FormInputProps {
  label: string;
  placeholder: string;
  callback: (value: string) => void;
  underlined: boolean;
}

const FormInput: React.FC<FormInputProps> = ({
  label,
  placeholder,
  callback,
  underlined,
}) => {
  const handleInputChange = (e: ChangeEvent<HTMLInputElement>) => {
    callback(e.target.value);
  };

  return (
    <div className="formInput">
      <label className="nameLabel">{label}</label>
      <input
        className="nameText"
        placeholder={placeholder}
        onChange={handleInputChange}
      />
    </div>
  );
};

export default FormInput;
