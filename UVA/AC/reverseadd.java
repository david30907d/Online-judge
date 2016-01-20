#include <stdio.h>
#include <stdlib.h>
int rev (int a)
{
   int r = 0;
   while ( a != 0 )
   {
      r = r * 10 + ( a % 10 );
      a /= 10;
   }
   return r;
}


int main (void)
{
   int i, time;
   scanf ("%d", &time);
   for ( i = 0;  i < time;  ++i )
   {
      int a, b;
      scanf ("%d%d", &a, &b);
      printf ("%d\n", rev (rev(a) + rev(b)));
   }
   return 0;
}
