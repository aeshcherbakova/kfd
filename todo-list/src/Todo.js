import bin from "./icons/bin.png"

export default function Todo(props) {
    const deleteTodo = () => props.deleteTodo(props.todo.id);

    return(
        <div key={props.todo.id} className="todo">
            <div>{props.todo.body}</div>
            <button className="delete-button" onClick={deleteTodo} >
                <img className="trash-icon" src={bin} alt="-"/>
            </button>
        </div>
    )
}