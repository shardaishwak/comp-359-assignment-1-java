import java.util.Arrays;


int[] numbers;
int maxNum;
int digit = 0;
int[] output;
int[] count;
int step = 0;
int substep = 0;
boolean sorting = true;
String status = "";
int speed =50; // max speed is 60 = frames/sec

void setup() {
  size(1200, 800);
  numbers = new int[50];
  for (int i = 0; i < numbers.length; i++) {
    numbers[i] = (int) random(1, 100);
  }
  maxNum = max(numbers);
  output = new int[numbers.length];
  count = new int[10];
}

void draw() {
  background(0);
  drawArrays();
  displayInfo();
  
  if (sorting && frameCount % (60 - speed) == 0) { 
    radixSortStep();
  }
}

void radixSortStep() {
  int n = numbers.length;
  
  switch(step) {
    case 0:
      if (substep == 0) {
        Arrays.fill(count, 0);
        status = "Initializing count array";
        step++;
        substep = 0;
      }
      break;
      
    case 1:
      if (substep < n) {
        int index = (numbers[substep] / (int) Math.pow(10, digit)) % 10;
        count[index]++;
        status = "Counting occurrences: number " + numbers[substep] + ", digit " + index;
        substep++;
      } else {
        step++;
        substep = 0;
      }
      break;
      
    case 2:
      if (substep < 9) {
        count[substep + 1] += count[substep];
        status = "Calculating cumulative count: index " + substep;
        substep++;
      } else {
        step++;
        substep = 0;
      }
      break;
      
    case 3:
      if (substep < n) {
        int i = n - 1 - substep;
        int index = (numbers[i] / (int) Math.pow(10, digit)) % 10;
        output[count[index] - 1] = numbers[i];
        count[index]--;
        status = "Building output array: placing " + numbers[i] + " at index " + (count[index]);
        substep++;
      } else {
        step++;
        substep = 0;
      }
      break;
      
    case 4:
      if (substep < n) {
        numbers[substep] = output[substep];
        status = "Copying output to original array: index " + substep;
        substep++;
      } else {
        digit++;
        if (digit > log10(maxNum)) {
          sorting = false;
          status = "Sorting completed";
        } else {
          step = 0;
          substep = 0;
          status = "Moving to next digit: " + digit;
        }
      }
      break;
  }
}

void drawArrays() {
  drawArray(numbers, "Numbers", 0, true);
  drawArray(count, "Count", height / 3, false);
  drawArray(output, "Output", 2 * height / 3, true);
}

void drawArray(int[] arr, String label, float yOffset, boolean showIndex) {
  fill(255);
  textSize(16);
  text(label, 10, yOffset + 20);
  
  float w = width / (float) arr.length;
  for (int i = 0; i < arr.length; i++) {
    float h = map(arr[i], 0, maxNum, 0, height / 3 - 60);
    fill(200, 100, 100);
    rect(i * w, yOffset + height / 3 - h - 40, w - 1, h);
    fill(255);
    textSize(10);
    text(arr[i], i * w, yOffset + height / 3 - 20);
    if (showIndex) {
      text(i, i * w, yOffset + height / 3 - 5);
    }
  }
}

void displayInfo() {
  fill(255);
  textSize(20);
  text("Digit: " + digit + " | Step: " + step + " | Substep: " + substep, 10, 30);
  text("Status: " + status, 10, 60);
}

int log10(int x) {
  return (int) (Math.log(x) / Math.log(10));
}
