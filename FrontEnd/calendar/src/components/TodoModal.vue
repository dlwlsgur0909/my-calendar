<template>
    <div>
      <div class="todo-modal">
        <h2 class="todo-modal-header">{{ selectedYear }}년 {{ selectedMonth+1 }}월 {{ selectedDate }}일 일정</h2>
        <div class="todo-input-box">
          <input type="text" size="30" placeholder="추가 일정을 입력하세요"> 
          <button class="todo-input-button">+</button>
        </div>
      </div>  
    </div>
</template>

<script>
export default {
  props: {
    selectedYear: {
      type: Number,
      required: true
    },
    selectedMonth: {
      type: Number,
      required: true
    },
    selectedDate: {
      type: Number,
      required: true
    },
  }
    
}
</script>

<style>
    
.todo-modal {
    position: absolute;
    top: calc(50vh - 30vh);
    left: calc(50vw - 15vw);
    border: 1px solid red;
    background: #fff;
    width: 30vw;
    height: 60vh;
}

.todo-modal-header {
  text-align: center;
}

.todo-input-box {
  text-align: center;
}

.todo-input-button {
  display: inline-block;
  font-size: 25px;
  margin-left: 10px;
  padding: 0 7px;
  background: rgb(54, 230, 157);
  border: none;
  border-radius: 15px;
  cursor: pointer;
}

.todo-input-button:hover {
  color: #ffffff;
}

</style>