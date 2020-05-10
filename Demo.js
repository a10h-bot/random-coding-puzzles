let mobRegex = new RegExp("^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$");

const mobNum = ["+919367788755",
    "8989829304",
    "+16308520397",
    "786-307-3615",
    "789",
    "123765",
    "1 - 1 - 1",
    "+ 982"];

for (let i = 0; i < mobNum.length; i++) {
    const element = mobNum[i];
    if (mobRegex.exec(element)) {
        mobNum[i] = true;
    }
    else
        mobNum[i] = false;
}

console.log(mobNum);



