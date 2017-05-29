#include <cstdint>
#include <cmath>
#include <vector>

//This union allows reinterpret the code of an ieee754 single precision number
//to an 32-bit unsigned integer
union float_binary {
    uint32_t binary_code;
    float real_number;
};

struct ieee754_single {
    float_binary number;
    void print_code();          //Prints the binary code of an float number
    char get_sign();            //Returns the sign of a normalized number (+/-)
    int get_exponent();    //Returns the decimal value of the exponent of a normalized number
    float get_mantissa();       //Return the decimal value of the mantissa of a normalized number
};

void ieee754_single::print_code() {
    //Prints the sign
    std::cout << ((number.binary_code & 0x80000000) == 0 ? '0' : '1') 
              << '\n';

    //Prints the exponent
    for (uint32_t i = 0; i < 8; i++)
        std::cout << ((number.binary_code & (0x40000000 >> i)) == 0 ? '0' : '1');
    std::cout << '\n';

    //Prints the mantissa
    for (uint32_t i = 0; i < 23; i++)
        std::cout << ((number.binary_code & (0x00400000 >> i)) == 0 ? '0' : '1');    
    std::cout << '\n';
}

char ieee754_single::get_sign() {
    return (number.binary_code & 0x80000000) == 0 ? '+' : '-'; 
}

int ieee754_single::get_exponent() {
    return ((number.binary_code & 0x7F800000) >> 23) - 127;
}

float ieee754_single::get_mantissa() {
    float_binary mantissa = number;
    mantissa.binary_code = (mantissa.binary_code & 0x007FFFFF);
    mantissa.binary_code = (mantissa.binary_code | 0x3F800000);
    return mantissa.real_number;
}