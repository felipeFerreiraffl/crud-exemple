import React from "react";
import './InputArea.css';
import Input from "../Input/Input";

function InputArea({ title }) {
    return (
        <div className="app-input-area">
            <h1 className="app-input-title">{title}</h1>
            <Input />
        </div>
    );
}

export default InputArea;