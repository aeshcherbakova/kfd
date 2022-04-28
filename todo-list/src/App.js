import Todo from "./Todo";
import TodoForm from "./TodoForm";
import { useEffect, useState } from "react";

export default function App() {
  const [todos, setTodos] = useState(JSON.parse(localStorage.getItem('todos')) ?? [{id: 1, body: "hahah"}]);

  useEffect(() => localStorage.setItem('todos', JSON.stringify(todos)), [todos]);

  const createTodo = (newTodo) => {
    console.log(todos);
    setTodos([...todos, newTodo]);
  };

  const deleteTodo = (id) => setTodos(todos.filter((todo) => todo.id !== id));

  return (
    <div className="app">
      <h3>Количество задач: {todos.length}</h3>
      <TodoForm createTodo={createTodo}/>
      {todos.map((todo) => <Todo 
        todo={todo} 
        key={todo.id}
        deleteTodo={deleteTodo}
      />
      )}
    </div>
  );
  
}