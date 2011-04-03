//These are nicer names for the control pins
#define CONTROL0 5
#define CONTROL1 4
#define CONTROL2 3
#define CONTROL3 2


//here are the arrays for the data form the MUXs
int mux0array[15];
//int mux1array[16];
//int mux2array[16];

void setup(){
	//set MUX control pins to output
	pinMode(CONTROL0, OUTPUT);
	pinMode(CONTROL1, OUTPUT);
	pinMode(CONTROL2, OUTPUT);
	pinMode(CONTROL3, OUTPUT);

	//open the serial port 
	Serial.begin(9600);
}

void loop(){
	//this loop is used to store the values of the 16 inputs on the first multipleer
	for(int i=0; i<16;i++){
		//the following 4 commands
		//uses arduino bitwise AND and bitshift
		digitalWrite(CONTROL0, (i&15)>>3);
		digitalWrite(CONTROL1, (i&7)>>2);
		digitalWrite(CONTROL2, (i&3)>>1);
		digitalWrite(CONTROL3, (i&1));
	//read and store the input values in the array at i
	mux0array[i] = analogRead(0);
	}
		
//	for(int i=0; i<16;i++){
//		//the following 4 commands
//		//uses arduino bitwise AND and bitshift
//		digitalWrite(CONTROL0, (i&15)>>3);
//		digitalWrite(CONTROL1, (i&7)>>2);
//		digitalWrite(CONTROL2, (i&3)>>1);
//		digitalWrite(CONTROL3, (i&1));
//	
//	//read and store the input values in the array at i
//	mux1array[i] = analogRead(1);
//	}
		
//	for(int i=0; i<16;i++){
//		//the following 4 commands
//		//uses arduino bitwise AND and bitshift
//		digitalWrite(CONTROL0, (i&15)>>3);
//		digitalWrite(CONTROL1, (i&7)>>2);
//		digitalWrite(CONTROL2, (i&3)>>1);
//		digitalWrite(CONTROL3, (i&1));
//	
//	//read and store the input values in the array at i
//	mux2array[i] = analogRead(2);
//	}
		
	//this is to read the array0
	
	//Serial.print("mux0array: ");
//	for (int i=0; i<11; i++){
//		Serial.print(mux0array[i]);
//		Serial.print("-");
//                if(mux0array[i]<200){
//                  if(i==1 && mux0array[i]==0){
//                    Serial.print(" "+String(i)+"f ");
//                  }else{
//                      //  Serial.println();
//			Serial.print(" " + String(i)+"f ");
//                     //   Serial.println();
//                  }
//		}
//                
//	}
//	Serial.println();
//			

for (int i=3; i<10; i++){
	//	Serial.print(mux0array[i]);
	//	Serial.print("-");
                if(mux0array[i]<300){
                      //  Serial.println();
			Serial.print(String(i)+"f");
                     //   Serial.println();
                  }
		}
                
	

	Serial.println();
//the following code has been uncommented for debugging purposes. it works its just not being used right now


//	Serial.print("mux1array: ");
//	for (int i=0; i<16; i++){
//	//	Serial.print(mux1array[i]);
//	//	Serial.print("-");
//                if(mux1array[i]>300){
//                        Serial.println();
//		  	Serial.print(String(i)+"T");
//                        Serial.println();
//		}
//	}
//        Serial.println();
//			
//			
//	Serial.print("mux2array: ");
//	for (int i=0; i<16; i++){
//	//	Serial.print(mux2array[i]);
//	//	Serial.print("-");
//                if(mux2array[i]>300){
//                        Serial.println();
//		  	Serial.print(String(i)+"T");
//                        Serial.println();
//		}
//	}
//	Serial.println();


        
}	
