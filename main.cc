#include <iostream>
#include <cstdlib>

#include "ieee754.h"

int main(int argc, char* argv[]) {
    ieee754_single single;
    single.number.real_number = std::atof(argv[1]);
    single.print_code();
    std::cout << single.get_sign() 
              << "(2^"
              << single.get_exponent()
              << ")("
              << single.get_mantissa()
              << ")"
              << std::endl;
    return 0;
}

