function printMe() {
    let i;
    for (i = 0; i <= 10; i++) {
        if (i == 4) {
            console.log(i + " "); continue;

        }
        else if (i != 4) {
            console.log(i + " ");

        }
        else {
            break;
        }

    }
}

printMe();