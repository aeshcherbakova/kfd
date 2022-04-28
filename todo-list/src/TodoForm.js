import { useRef } from "react";

export default function TodoForm(props) {
    const userInput = useRef();
    
    const addTodo = (e) => {
        e.preventDefault();
        if(userInput.current.value) {
            const newTodo = {
                id: Date.now(),
                body: userInput.current.value
            }
            props.createTodo(newTodo);
        }
        userInput.current.value = "";
    }

    return(
        <form action="">
            <input className="customIpt" ref={userInput} type="text" placeholder="Введите задачу"/>
            <button className="add-button" onClick={addTodo}>Добавить</button>
        </form>
    )
}