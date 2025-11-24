public class GuitarHero {
public static void main(String[] args) {
String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
int N = keyboard.length();
GuitarString[] strings = new GuitarString[N];
for (int i = 0; i < N; i++) {
double freq = 440.0 * Math.pow(1.05956, i - 24);
strings[i] = new GuitarString(freq);
}
while (true) {
    if (StdDraw.hasNextKeyTyped()) {
        char key = StdDraw.nextKeyTyped();
        int idx = keyboard.indexOf(key);
        if (idx >= 0) strings[idx].pluck();
    }
double sample = 0.0;
for (int i = 0; i < N; i++) sample += strings[i].sample();
StdAudio.play(sample);
for (int i = 0; i < N; i++) strings[i].tic();
}
}
}