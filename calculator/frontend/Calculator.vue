<template>
  
  <div class="calculator">
    <div class="extend">{{getDisplay()||0}}</div>
    <div class="display">{{getResult()||0}}</div>
    <div class="button" @click="clearDisplay()">C</div>
    <div class="button"  @click="toggle()">+/-</div>
    <div class="button" @click="percent()">%</div>
    <div class="operator button" @click="deleteLast()">⌫</div>
    <div class="button" @click="fraction()">1 &#8725; x</div>
    <div class="button" @click="power()">x²</div>
    <div class="button" @click="root()">&radic;x</div>
    <div class="button operator"  @click="addToDisplay('÷')">&#xf7;</div>
    <div class="button"  @click="addToDisplay('7')">7</div>
    <div class="button"  @click="addToDisplay('8')">8</div>
    <div class="button"  @click="addToDisplay('9')">9</div>
    <div class="button operator"  @click="addToDisplay('*')">x</div>
    <div class="button"  @click="addToDisplay('4')">4</div>
    <div class="button"  @click="addToDisplay('5')">5</div>
    <div class="button"  @click="addToDisplay('6')">6</div>
    <div class="button operator"  @click="addToDisplay('-')">-</div>
    <div class="button"  @click="addToDisplay('1')">1</div>
    <div class="button"  @click="addToDisplay('2')">2</div>
    <div class="button"  @click="addToDisplay('3')">3</div>
    <div class="button operator"  @click="addToDisplay('+')">+</div>
    <div class="button zero"  @click="addToDisplay('0')">0</div>
    <div class="button"  @click="addToDisplay('.')">.</div>
    <div class="button equal operator" @click="equal()" >=</div>
    <div class="middle"></div>

  </div>
</template>

<script>
export default {
  data(){
    return{
       displayString:'',
       sendingString:'',
       lastChar:'',
       lastSending:'',
       tempSending:'',
       beforeLastChar:'',
       temp:'',
       checker:'',
       result:''
    };

  },
  methods: {
    addToDisplay(value) {
      this.displayString += value; 
      if(value!=='÷')
      this.sendingString+=value;
      else
      this.sendingString+='/';
    },
    addSending(value){
       this.sendingString+=value;

    },
    
    getDisplay() {
      return this.displayString; 
    },
    getResult(){
      return this.result;
    },
    getSending(){
     return this.sendingString;

    },
    clearDisplay(){
      this.displayString = '';
      this.result='';
      this.sendingString='';
      
    },
    deleteLast(){

      this.displayString = this.displayString.slice(0,-1);
      this.deleteLastSending();
            
            
    },
    deleteLastSending(){
      this.sendingString=this.sendingString.slice(0,-1);
    },
    getLast(){
      
      this.lastChar=this.displayString.slice(-1);
      

    },
    getLastSending(){
      this.lastSending=this.sendingString.slice(-1);

    },
   
    fraction(){
      this.getLast();

      if(this.lastChar!=='+'&&this.lastChar!=='-'&&this.lastChar!=='x'&&this.lastChar!=='÷'&&this.lastChar.length!==0){
      this.deleteLast();
      this.deleteLastSending();
      this.temp=this.lastChar;
      this.getLast();
      while(this.lastChar!=='+'&&this.lastChar!=='-'&&this.lastChar!=='x'&&this.lastChar!=='÷'&&this.lastChar.length!==0)
      {
        this.temp+=this.lastChar;
        this.deleteLast();
        this.deleteLastSending;
        this.getLast();
      }
      
      
     
      
      this.temp=this.temp.split('').reverse().join('');
      this.checker=this.displayString.slice(-1);
      this.sendingString+=this.checker;
      this.displayString+='1';
      this.sendingString+='1'
      this.displayString+='/';
      this.sendingString+='/';
      this.displayString+=this.temp;
      this.sendingString+=this.temp;
      }
      else{
        this.displayString+='1/1';
        this.sendingString+='1'
      }

    },
    root(){
      this.getLast();
      if(this.lastChar!=='+'&&this.lastChar!=='-'&&this.lastChar!=='x'&&this.lastChar!=='÷'&&this.lastChar.length!==0){
      this.displayString+='**0.5';
      
      this.getLastSending();
      if(this.lastSending!=='+'&&this.lastSending!=='-'&&this.lastSending!=='x'&&this.lastSending!=='÷'&&this.lastSending.length!==0){
      this.deleteLastSending();
      this.tempSending=this.lastSending;
      this.getLastSending();
      while(this.lastSending!=='+'&&this.lastSending!=='-'&&this.lastSending!=='x'&&this.lastSending!=='÷'&&this.lastSending.length!==0)
      {
        this.tempSending+=this.lastSending;
        this.deleteLastSending();
        this.getLastSending();
      }
      this.getLastSending();
      if(this.lastSending=='-'&&this.sendingString.length===1)
      {
        this.displayString='E'
        this.result='E'
        this.sendingString='E'
      }

      this.tempSending=this.tempSending.split('').reverse().join('');
      let num = parseInt(this.tempSending); // Convert string to number
      let rootval = num ** 0.5; // Square the number
      this.tempSending = rootval.toString();
      this.addSending(this.tempSending);
      
      }
      else{
        this.displayString+='1**0.5'
      }
      
    }},
    power(){
      this.getLast();
      if(this.lastChar!=='+'&&this.lastChar!=='-'&&this.lastChar!=='x'&&this.lastChar!=='÷'&&this.lastChar.length!==0){
      this.displayString+='**2';
      

      this.getLastSending();

      if(this.lastSending!=='+'&&this.lastSending!=='-'&&this.lastSending!=='x'&&this.lastSending!=='÷'&&this.lastSending.length!==0){
      this.deleteLastSending();
      this.tempSending=this.lastSending;
      this.getLastSending();
      while(this.lastSending!=='+'&&this.lastSending!=='-'&&this.lastSending!=='x'&&this.lastSending!=='÷'&&this.lastSending.length!==0)
      {
        this.tempSending+=this.lastSending;
        this.deleteLastSending();
        this.getLastSending();
      }
      
      this.tempSending=this.tempSending.split('').reverse().join('');
      let num = parseInt(this.tempSending); // Convert string to number
      let squared = num * num; // Square the number
      this.tempSending = squared.toString();
      this.addSending(this.tempSending);
      
      }}
      else{
        this.displayString+='1**2';
        this.addSending('1');
      }
    },

    toggle(){
      this.getLast();
      
      if(this.lastChar!=='+'&&this.lastChar!=='-'&&this.lastChar!=='x'&&this.lastChar!=='÷'&&this.lastChar.length!==0){
      this.deleteLast();
      this.temp=this.lastChar;
      this.getLast();
      while(this.lastChar!=='+'&&this.lastChar!=='-'&&this.lastChar!=='x'&&this.lastChar!=='÷'&&this.lastChar.length!==0)
      {
        this.temp+=this.lastChar;
        this.deleteLast();
        this.getLast();
      }
      
      
     
      
      this.temp=this.temp.split('').reverse().join('');
      this.getLast();
      if(this.lastChar==='-'){
         this.deleteLast();
         this.displayString+='+';
         this.sendingString+='+';
         this.displayString+=this.temp;
         this.sendingString+=this.temp;
      }
      else{
       this.deleteLast(); 
       this.displayString+='-';
       this.sendingString+='-';
       this.displayString+=this.temp;
       this.sendingString+=this.temp;

      }
     


    }

  },
  equal(){
    if(this.sendingString.length!==0&&this.sendingString!=='0'){
      fetch("/cal/ev?exp="+this.sendingString)
      .then((response)=>response.text())
      .then((data) => {
        this.result=data.toString();
        this.sendingString=this.result;
        this.displayString=this.result;
      })
      .catch((error) => {
      console.error('Error fetching data:', error);
    });

  }
  else{
      this.displayString = '';
      this.result='';
      this.sendingString='';


  }
  
  },
  percent(){

      this.getLast();
      if(this.lastChar!=='+'&&this.lastChar!=='-'&&this.lastChar!=='x'&&this.lastChar!=='÷'&&this.lastChar.length!==0){
      this.deleteLast();
      this.temp=this.lastChar;
      this.getLast();
      while(this.lastChar!=='+'&&this.lastChar!=='-'&&this.lastChar!=='x'&&this.lastChar!=='÷'&&this.lastChar.length!==0)
      {
        this.temp+=this.lastChar;
        this.deleteLast();
        this.getLast();
      }
      
      this.temp=this.temp.split('').reverse().join('');
      let num = parseInt(this.temp); // Convert string to number
      let rootval = num/100; // Square the number
      this.temp = rootval.toString();
      this.addToDisplay(this.temp);



  }



     this.getLastSending();
      if(this.lastSending!=='+'&&this.lastSending!=='-'&&this.lastSending!=='x'&&this.lastSending!=='÷'&&this.lastSending.length!==0){
      this.deleteLastSending();
      this.tempSending=this.lastSending;
      this.getLastSending();
      while(this.lastSending!=='+'&&this.lastSending!=='-'&&this.lastSending!=='x'&&this.lastSending!=='÷'&&this.lastSending.length!==0)
      {
        this.tempSending+=this.lastSending;
        this.deleteLastSending();
        this.getLastSending();
      }
      this.addSending(this.temp);
      
   

  }}
  
}}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.calculator{
  margin: 0 auto;
  width: 300px;
  height: 400px;
  font-size: 20px;
  display: grid;
  grid-template-columns: repeat(4,1fr);
  grid-auto-rows: minmax(50px,auto);
  background-color: #09171a;
  border-radius: 25px;
  user-select: none;
  

}
.extend{
  
  background-color: black;
  border-top-left-radius: 25px;
  border-top-right-radius: 25px;
  grid-column: 1/5;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding-right: 15px;
}

.display{
  font-size: 50px;
  grid-column: 1/5;
  background-color: black;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding-right: 15px;
  
}
.zero{
  border-bottom-left-radius: 15px;
}
.button.operator{
background-color: #114f54;
color: white;
font-size: 25px;
}
.button.equal.operator{
background-color: #2aaea1;  
grid-column: 3/5;
border-bottom-right-radius: 15px;
border-top-left-radius: 15px;

}
.button{
  background-color: #09171a;
  color: white;
  border:0.5px #09171a solid ;
  display: flex;
  justify-content: center;
  align-items: center;
}
.button:hover{
background-color: #050c0e;
}
.button.operator:hover{
background-color: #0d3e41;

}
.button.equal.operator:hover{
background-color: #228d82;  


}

</style>
