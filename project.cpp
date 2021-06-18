#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>

#define MAXFILES 100
#define FILESIZE 1024

struct SuperBlock
{
    int TotalInodes;
    int FreeInode;
}Obj_Super;

struct inode
{
    char File_name[50];
    int Inode_number;
    int File_Size;
    int File_Type;
    int ActualFileSize;
    int Link_Count;
    int Reference_Count;
    char * Data;
    struct inode *next;
};

typedef struct inode INODE;
typedef struct inode * PINODE;
typedef struct inode ** PPINODE;

struct FileTable
{
    int ReadOffset;
    int WriteOffset;
    int Count;
    PINODE ptr;
    int Mode;
};

typedef FileTable FILETABLE;
typedef FileTable * PFILETABLE;

struct UFDT
{
    PFILETABLE ufdt[MAXFILES];
}UFTDObj;



PINODE Head = NULL; // Global pointer of inode
    
void CreateUFDT()
{
    int i = 0;
    
    for(i = 0; i < MAXFILES; i++)
    {
        UFTDObj.ufdt[i] = NULL;
    }
}

void CreateDILB()   // Create linked list of iniodes
{
    // Create linked list of inodes
    int i = 1;
    PINODE newn = NULL;
    PINODE temp = Head;
    
    while(i <= MAXFILES)   // Loop iterates 100 times
    {
        newn = (PINODE)malloc(sizeof(INODE));
        
        newn->Inode_number = i;
        newn->File_Size = FILESIZE;
        newn->File_Type = 0;
        newn->ActualFileSize = 0;
        newn->Link_Count = 0;
        newn->Reference_Count = 0;
        newn->Data = NULL;
        newn->next = NULL;
        
        if(Head == NULL)    // First inode
        {
            Head = newn;
            temp = Head;
        }
        else    // iNode second onwords
        {
            temp->next = newn;
            temp = temp ->next;
        }
        
        i++;
    }
    
    printf("DILB created succesfully!!\n");
}

void CreateSuperBlock()
{
    Obj_Super.TotalInodes = MAXFILES;
    Obj_Super.FreeInode = MAXFILES;
    
    printf("Super block created Succesfully\n");
}

void SetEnvoirnment()
{
    CreateDILB();
    CreateSuperBlock();
    CreateUFDT();
    printf("Envoirnment for the Virtual file system is set...\n");
}

void DisplayHelp()
{
    printf("-----------------------------------------------------\n");
    printf("open : It is used to open the existing file\n");
    printf("close : It is used to close the opened file\n");
    printf("read : It is used to read the contents of file\n");
    printf("write : It is used to write the data into file\n");
    printf("lseek : It is used to change the offset of file\n");
    printf("stat : It is used to odisplay the information of file\n");
    printf("fstat : It is used to display the information of opened file\n");
    printf("-----------------------------------------------------\n");
}

void ManPage(char *str)
{
    if(strcmp(str,"open") == 0)
    {
        printf("Desricption : It is used to open an existing file \n");
        printf("Usage : open File_name Mode\n");
    }
    else if (strcmp(str,"close") == 0)
    {
        printf("Desricption : It is used to close the existing file\n");
        printf("Usage : close File_name\n");
    }
    else if (strcmp(str,"ls") == 0)
    {
        printf("Desricption : It is used to list out all names of the files\n");
        printf("Usage : ls\n");
    }
    else
    {
        printf("Man page not found\n");
    }
}

int main()
{
    // Variable Declations
    char str[80];
    char command[4][80];
    int count = 0;

    printf("Customised Virtual File System\n");
    
    SetEnvoirnment();
    
    while(1)
    {
        printf("Marvellous VFS :> ");
        fgets(str,80,stdin); // Accept the coomand
        fflush(stdin);
        
        count = sscanf(str,"%s %s %s %s",command[0],command[1],command[2],command[3]);  // Break that command ito tokens
        
        if(count == 1)
        {
                if(strcmp(command[0], "help") == 0)
                {
                    DisplayHelp();
                }
                else if(strcmp(command[0],"exit") == 0)
                {
                    printf("Thank you for using Marvellous Virtual file system");
                    break;
                }
                else if(strcmp(command[0],"clear") == 0)
                {
                    system("clear");    // cls
                }
                else
                {
                    printf("Command not found !!\n");
                }
        }
        else if(count == 2)
        {
            if(strcmp(command[0],"man") == 0)   // man open
            {
                ManPage(command[1]);
            }
            else
            {
                printf("Command not found !!\n");
            }
        }
        else if (count == 3)
        {}
        else if(count == 4)
        {}
        else
        {
            printf("Bad command or file name\n");
        }
        
    }
    
    return 0;
}
